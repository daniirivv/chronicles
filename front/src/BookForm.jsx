import './Dashboard.css';

function BookForm({ formData, setFormData, showList, saveBook }) {
    return (
        <div>
            <h2>{formData.id ? 'Modificar Entrada' : 'Crear Nueva Entrada'}</h2>

            <div className="book-card" style={{ display: 'flex', flexDirection: 'column', gap: '10px' }}>

                <input
                    placeholder="Título del libro"
                    value={formData.title}
                    onChange={(e) => setFormData({ ...formData, title: e.target.value })}
                    style={{ padding: '8px' }}
                />
                <input
                    placeholder="Autor"
                    value={formData.author}
                    onChange={(e) => setFormData({ ...formData, author: e.target.value })}
                    style={{ padding: '8px' }}
                />
                <input
                    placeholder="Número de páginas"
                    type="number"
                    value={formData.pages}
                    onChange={(e) => setFormData({ ...formData, pages: e.target.value })}
                    style={{ padding: '8px' }}
                />
                <input
                    placeholder="Año de lanzamiento"
                    type="number"
                    value={formData.releaseDate}
                    onChange={(e) => setFormData({ ...formData, releaseDate: e.target.value })}
                    style={{ padding: '8px' }}
                />

                <label style={{ display: 'flex', alignItems: 'center', gap: '10px', padding: '8px' }}>
                    <input
                        type="checkbox"
                        checked={formData.completed}
                        onChange={(e) => setFormData({ ...formData, completed: e.target.checked })}
                    />
                    ¿Terminado?
                </label>

                <input
                    placeholder="Valoración"
                    type="number"
                    value={formData.rating}
                    onChange={(e) => setFormData({ ...formData, rating: e.target.value })}
                    style={{ padding: '8px' }}
                />

                <div style={{ display: 'flex', gap: '10px', marginTop: '10px' }}>
                    <button
                        onClick={showList}
                        style={{ cursor: 'pointer', padding: '10px 15px', border: '1px solid #ddd', borderRadius: '5px', backgroundColor: 'transparent' }}
                    >
                        Cancelar
                    </button>

                    <button
                        className="btn-primary"
                        onClick={saveBook}
                    >
                        Guardar
                    </button>
                </div>
            </div>
        </div>
    );
}

export default BookForm;