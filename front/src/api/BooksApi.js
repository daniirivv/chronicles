const url = '/books'

function getBooks() {
    return fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error(`Error HTTP: ${response.status}`);
            }

            return response.json()
        })
}

function getBook(id) {
    return fetch(url + `/${id}`)
        .then(response => {
            if (!response.ok) {
                throw new Error(`Error HTTP: ${response.status}`);
            }

            return response.json()
        })
}

function createBook(bookData) {
    return fetch(url, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(bookData)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error(`Error HTTP: ${response.status}`);
            }

            return response.json()
        })
}

function updateBook(id, bookData) {
    return fetch(url + `/${id}`, {
        method: 'PATCH',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(bookData)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error(`Error HTTP: ${response.status}`);
            }

            return response.json()
        })
}

function deleteBook(id) {
    return fetch(url + `/${id}`, {
        method: 'DELETE'
    })
        .then(response => {
            if (!response.ok) {
                throw new Error(`Error HTTP: ${response.status}`);
            }
        })
}

export {getBooks, getBook, createBook, updateBook, deleteBook};