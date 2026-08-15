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

export { getBooks };