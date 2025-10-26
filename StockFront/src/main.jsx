import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import { store } from './Store.js'
import { Provider } from 'react-redux' // ✅ Importa o Provider
import App from './App.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <Provider store={store}>   {/* ✅ Agora o Redux funciona */}
      <App/>
    </Provider>
  </StrictMode>,
)
  