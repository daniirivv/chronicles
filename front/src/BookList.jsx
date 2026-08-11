import './Dashboard.css';

function BookList({ books, showCreateForm, showDetails }) {
    return (
        <div>
            <button className="btn-primary" onClick={showCreateForm} style={{ marginBottom: '20px' }}>
                Crear entrada
            </button>

            {books.length === 0 ? (
                <p>No hay libros todavía. ¡Crea el primero!</p>
            ) : (
                books.map((book) => (
                    <div key={book.id} className="book-card">
                        <h3>{book.title}</h3>
                        <p>Autor: {book.author}</p>

                        <button className="btn-primary" onClick={() => showDetails(book)} style={{ marginTop: '10px' }}>
                            Ver detalles
                        </button>
                    </div>
                ))
            )}
        </div>
    );
}

export default BookList;