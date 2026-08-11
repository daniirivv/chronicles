import './Dashboard.css';

function BookDetails({ book, showList, showEditForm, deleteBook }) {
    return (
        <div className="dashboard-container book-card">
            <h2>{book.title}</h2>
            <p><strong>Autor:</strong> {book.author}</p>
            <p><strong>Páginas:</strong> {book.pages}</p>
            <p><strong>Fecha de publicación:</strong> {book.releaseDate}</p>
            <p><strong>Estado:</strong> {book.completed ? 'Terminado ✅' : 'Pendiente ⏳'}</p>
            <p><strong>Valoración:</strong> {book.rating ? `${book.rating} / 10` : 'Sin valorar'}</p>

            <div style={{ marginTop: '20px', display: 'flex', gap: '10px' }}>
                <button className="btn-primary" onClick={showList}>
                    Volver a la lista
                </button>
                <button className="btn-primary" onClick={() => showEditForm(book)}>
                    Editar
                </button>

                <button
                    style={{ backgroundColor: '#dc3545', color: 'white', border: 'none', padding: '10px 15px', borderRadius: '5px', cursor: 'pointer', fontWeight: 'bold' }}
                    onClick={() => deleteBook(book.id)}
                >
                    Eliminar
                </button>
            </div>
        </div>
    );
}

export default BookDetails;