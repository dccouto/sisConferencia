import { IconButton, Tooltip } from '@mui/material'
import { useNavigate } from 'react-router-dom'

// Hooks
import { useAuth } from '../../../../hooks/useAuth'

//Componentes
import LogoutIcon from '@mui/icons-material/Logout'

export function LogoutButton() {
    const { logout, auth } = useAuth()

    const navigate = useNavigate()

    function onLogout() {
        logout()
        navigate('/')
    }

    if (!auth.autenticado) {
        return null
    }

    return (
        <Tooltip title='Sair'>
            <span>
                <IconButton color='secondary' size='large' edge='start' onClick={onLogout}>
                    <LogoutIcon fontSize='inherit' />
                </IconButton>
            </span>
        </Tooltip>
    )
}
