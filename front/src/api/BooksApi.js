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

export { getBooks, createBook, updateBook};