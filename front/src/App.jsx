import Dashboard from './Dashboard';
import './Dashboard.css';

function App() {
  return (
      <div style={{ maxWidth: '800px', margin: '0 auto', padding: '20px', fontFamily: 'sans-serif' }}>
        <header style={{ textAlign: 'center', marginBottom: '30px' }}>
          <h1 className='brand-title'>Chronicles</h1>
        </header>

        <main>
            <Dashboard />
        </main>
      </div>
  );
}

export default App;