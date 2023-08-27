const URL1 = "https://jsonplaceholder.typicode.com/posts?userId=";
const URL2 = "https://jsonplaceholder.typicode.com/posts/";
const KEY = "ETF";
id = 0;
posts = [];
reviews = [];

function sendRequest() {
    let id = document.getElementById("id").value;
    $.ajax({
        url: URL1 + id,
        type: "GET",
        success: function(data) {
            posts = data;
            if (data.length == 0)
                alert("No posts");
            else {
                console.log(posts);
                createList();
            }
        },
        error: function(error) {
            console.log(`Error ${error}`);
        }
    });
}

function createList() {
    let ul = document.getElementById("posts");
    for (const post of posts) {
        let li = document.createElement("li");
        let a = document.createElement("a");
        a.href = "second.html?id=" + post.userId;
        a.innerHTML = post.title;
        li.appendChild(a);
        ul.appendChild(li);
    }
}

function initSecond() {
    const params = new URLSearchParams(window.location.search);
    id = params.get("id");
    $.ajax({
        url: URL2 + id,
        type: "GET",
        success: function(data) {
            createContent(data);
        },
        error: function(error) {
            console.log(`Error ${error}`);
        }
    });
    loadData();
}

function loadData() {
    // load reviews from local storage
    var storage = localStorage.getItem(KEY);
    if (storage && storage.length) {
        reviews = JSON.parse(storage);
    }
}

function createContent(data) {
    let content = document.getElementById("content");
    for (const key in data) {
        if (data.hasOwnProperty(key)) {
            const value = data[key];
            let div = document.createElement("div");
            div.innerHTML = `${key}: ${value}`;
            content.appendChild(div);
        }
    }
}

function save() {
    let elements = document.forms[0].elements;
    var obj = {
        id: id,
        grade: elements[0].value,
        comment: elements[1].value
    };
    reviews.push(obj);
    localStorage.setItem(KEY, JSON.stringify(reviews));
    location.href = "third.html";
}

function initThird() {
    loadData();
    console.log('Reviews', reviews);
    let tableBody = document.getElementById("tableBody");
    tableBody.innerHTML = "";
    let i = 0;
    for (let review of reviews) {
        let tr = document.createElement("tr");
        let id = document.createElement("td");
        let grade = document.createElement("td");
        let comment = document.createElement("td");
        let actions = document.createElement("td");
        let action = document.createElement("a");
        action.innerHTML = "Delete";
        action.href = "javascript:deleteComment(" + i + ")";
        actions.appendChild(action);
        id.innerHTML = review.id;
        grade.innerHTML = review.grade;
        comment.innerHTML = review.comment;
        tr.appendChild(id);
        tr.appendChild(grade);
        tr.appendChild(comment);
        tr.appendChild(actions);
        tableBody.appendChild(tr);
        i++;
    }

    // 3 best posts
    // Step 1: Group posts by ID
    const groupedReviews = reviews.reduce((groups, review) => {
        const { id } = review;
        if (!groups[id]) {
            groups[id] = [];
        }
        groups[id].push(review);
        return groups;
    }, {});

    console.log('Grouped reviews:', groupedReviews);

    // Step 2: Calculate average grade for each group
    for (const id in groupedReviews) {
        const reviewsById = groupedReviews[id];
        let sum = 0;
        for (let review of reviewsById) {
            sum += Number.parseInt(review.grade);
        }
        groupedReviews[id].averageGrade = sum / reviewsById.length;
    }

    // Step 3: Sort groups based on average grade
    const sortedGroups = Object.values(groupedReviews).sort((a, b) => b.averageGrade - a.averageGrade);
    console.log('Sorted', sortedGroups);

    var bestPosts = [];
    let ul = document.getElementById("bestPosts");
    let j = 0;
    for (let sorted of sortedGroups) {
        if (j == 3)
            break;
        console.log(sorted[0].id);
        $.ajax({
            url: URL2 + sorted[0].id,
            type: "GET",
            success: function(data) {
                bestPosts.push(data);
                let li = document.createElement("li");
                li.innerHTML = `${data.id} ${data.title}`;
                ul.appendChild(li);
            },
            error: function(error) {
                console.log(`Error ${error}`);
            }
        });
        j++;
    }

    console.log('Posts', posts);
    console.log('Best posts', bestPosts);


}

function deleteComment(id) {
    reviews.splice(id, 1);
    console.log("After deleting", reviews);
    localStorage.setItem(KEY, JSON.stringify(reviews));
    initThird();
}