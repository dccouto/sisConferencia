import { QueryClientProvider } from 'react-query'
import { ReactQueryDevtools } from 'react-query/devtools'
import { queryClient } from './services/queryClient'
import { CssBaseline, ThemeProvider } from '@mui/material'
import { theme } from './utils/theme'
import { LocalizationProvider } from '@mui/lab'
import ptBr from 'date-fns/locale/pt-BR'
import AdapterDateFns from '@mui/lab/AdapterDateFns'
import { BrowserRouter } from 'react-router-dom'
import { DrawerProvider } from './components/CidadaniaApp/Drawer/hooks/useDrawer'
import { SnackbarProvider } from 'notistack'
import { CidadaniaApp } from './components/CidadaniaApp'
import { AuthProvider } from './hooks/useAuth'

// CSS GLOBAL
import './assets/style.css'

function App() {
    return (
        <QueryClientProvider client={queryClient}>
            <ThemeProvider theme={theme}>
                <CssBaseline />
                <AuthProvider>
                    <LocalizationProvider dateAdapter={AdapterDateFns} locale={ptBr}>
                        <BrowserRouter>
                            <DrawerProvider>
                                <SnackbarProvider
                                    maxSnack={3}
                                    autoHideDuration={6000}
                                    anchorOrigin={{
                                        vertical: 'top',
                                        horizontal: 'center',
                                    }}
                                >
                                    <CidadaniaApp />
                                </SnackbarProvider>
                            </DrawerProvider>
                        </BrowserRouter>
                    </LocalizationProvider>
                </AuthProvider>
            </ThemeProvider>
            <ReactQueryDevtools />
        </QueryClientProvider>
    )
}

export default App
