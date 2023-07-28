import { Box, Grid } from '@mui/material'
import { Outlet } from 'react-router-dom'
import { useDrawer } from '../../../components/CidadaniaApp/Drawer/hooks/useDrawer'
import { DescSistema } from '../../../components/CidadaniaApp/Header/components/DescSistema'

export default function LoginContainer() {
    const { isDesktop } = useDrawer()
    
    const imageSize = isDesktop ? 400 : 0

    return (
        <Grid
            container
            sx={{
                my: -2,
                mx: -3, //pra ignorar o espaçamento padrão
                flexGrow: 1,
            }}
        >

 
       <Grid container spacing={2}>
       {isDesktop ? (
        <Grid
            item
            xs={12}
            sm={6}
            sx={{
                display: 'flex',
                flexDirection: 'column',
                justifyContent: 'space-between',
                alignItems: 'center',
                bgcolor: (theme) => '#F1F6FF',
                border: `${isDesktop ? '0px solid #D4D4D4' : ''}`,
                width: `100%`,
            }}
        >
          
             <Box sx={{ 
                display: 'flex', 
                alignItems: 'center', 
                justifyContent: 'center', 
                width: '100%', 
                height: '100%',
                marginRight: '20%', 
            }}>
                <DescSistema fontSize={56} />
            </Box>
           
            <img
                src='/illustra.svg'
                style={{ width: '522px',
                    height: '333px',
                    top: '426px',
                    left: '111px'
                     }}
                alt='Minha Rede Suas'
                className={'titulo'}
            />
        </Grid>
        ) : null}
        <Grid
            item
            xs={12}
            sm={6}
            sx={{
                bgcolor: (theme) => theme.palette.background.default,
                padding: 3,
            }}
        >
            <Outlet />
        </Grid>
    </Grid>

        </Grid>
    )
}
