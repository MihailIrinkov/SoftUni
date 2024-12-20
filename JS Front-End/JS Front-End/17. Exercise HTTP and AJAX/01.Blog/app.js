function attachEvents() {
    const baseURL = 'http://localhost:3030/jsonstore/blog';

    const selectPosts = document.querySelector('#posts');

    const postTitelEl = document.querySelector('#post-title');
    const postBodyEl = document.querySelector('#post-body');
    const postCommentsEl = document.querySelector('#post-comments');

    document.querySelector('#btnLoadPosts').addEventListener('click', loadHandler);
    document.querySelector('#btnViewPost').addEventListener('click', viewHandler);

    function loadHandler(e) {

        selectPosts.innerHTML = '';
        
        fetch(baseURL + '/posts')
            .then(response => response.json())
            .then(posts => {

                Object.values(posts).forEach(post => {
                    const optionEl = document.createElement('option');

                    // optionEl.dataset.id = post.id;
                    // optionEl.dataset.title = post.title;
                    // optionEl.dataset.body = post.body;

                    Object.assign(optionEl.dataset, post);

                    optionEl.textContent = post.title;
                    selectPosts.append(optionEl);
                });
            })
            .catch(error => console.error('Error: ', error));
    }

        function viewHandler(e) {

            fetch(baseURL + '/comments')
                .then(response => response.json())
                .then(comments => {
                    console.log(comments);

                    const optionEl = selectPosts.querySelector('option:checked');

                    postTitelEl.textContent = optionEl.dataset.title;
                    postBodyEl.textContent = optionEl.dataset.body;

                    Object.values(comments).forEach(comment => {
                        if (comment.postId === optionEl.dataset.id) {
                            const commentEl = document.createElement('li');
                            commentEl.textContent = comment.text;
                            postCommentsEl.append(commentEl);
                        }
                    })

                })
                .catch(error => console.error('Errors: ', error));
        }
}

attachEvents();