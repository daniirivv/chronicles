import {Navigate, Route, Routes} from 'react-router';

import BookList from './components/BookList.jsx';
import BookDetails from './components/BookDetails.jsx';
import BookForm from './components/BookForm.jsx';

function App() {
    return (
        <>
            <header className="brand-title">
                <h1>Chronicles</h1>
            </header>

            <div className="content-container">
                <main>
                    <Routes>
                        <Route
                            path="/"
                            element={<Navigate to="/books" replace />}
                        />

                        <Route
                            path="/books"
                            element={<BookList />}
                        />

                        <Route
                            path="/books/new"
                            element={<BookForm />}
                        />

                        <Route
                            path="/books/:id"
                            element={<BookDetails />}
                        />

                        <Route
                            path="/books/:id/edit"
                            element={<BookForm />}
                        />
                    </Routes>
                </main>
            </div>
        </>
    );
}

export default App;