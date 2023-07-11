import { Grid } from '@mui/material'
import { Outlet } from 'react-router-dom'
import { useDrawer } from '../../../components/CidadaniaApp/Drawer/hooks/useDrawer'

export default function LoginContainer() {
    const { isDesktop } = useDrawer()

    return (
        <Grid
            container
            justifyContent={isDesktop ? 'center' : ''}
            alignItems={isDesktop ? 'center' : ''}
            sx={{
                bgcolor: (theme) => (isDesktop ? theme.palette.background.dark : theme.palette.background.white),
                my: -2,
                mx: -3,
                width: `calc(100% + 48px)`, //pra ignorar o espaçamento padrão
                flexGrow: 1,
            }}
        >
            <Grid
                item
                sx={{
                    bgcolor: (theme) => theme.palette.background.default,
                    border: `${isDesktop ? '1px solid #D4D4D4' : ''}`,
                    borderRadius: '10px',
                    padding: 3,
                }}
            >
                <Outlet />
            </Grid>
        </Grid>
    )
}
