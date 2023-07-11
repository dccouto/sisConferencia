import { Box, Container, Typography } from '@mui/material'

export function Footer() {
    return (
        <Box
            component='footer'
            sx={{
                width: '100%',
                textAlign: 'center',
                position: 'absolute',
                py: 1.25,
                px: 1.25,
                mt: 'auto',
                color: (theme) => theme.palette.primary.contrastText,
                background: (theme) => theme.palette.primary.main,
                zIndex: (theme) => theme.zIndex.drawer + 1,
            }}
        >
            <Container
                maxWidth='sm'
                style={{
                    display: 'flex',
                    flexDirection: 'row',
                    justifyContent: 'center',
                    alignItems: 'center',
                }}
            >
                <img src='/logo.png' width={30} height={35} alt='SUAS' style={{ marginRight: 30, border: 0 }} />
                <Typography variant='body2'>Conselho Nacional de Assistência Social –CNAS</Typography>
            </Container>
        </Box>
    )
}
