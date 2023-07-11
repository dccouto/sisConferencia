import { Box, Grid, Typography, useTheme } from '@mui/material'
import { govBrConstants } from '../../../utils/constants'
import logo from '../../../assets/logo.png'
import { BotaoLoginGovBr } from '../components/BotaoLoginGovBr'

export default function LoginForm() {
    const theme = useTheme()

    const qs = [
        'response_type=code',
        `client_id=${govBrConstants.clientId}`,
        'scope=openid',
        `redirect_uri=${govBrConstants.redirectUri}`,
    ].join('&')

    return (
        <Grid container spacing={3} justifyContent='center' alignItems='center'>
            <Grid item xs={12} sm={6}>
                <Box
                    component='img'
                    src={logo}
                    alt='Logo'
                    sx={{
                        [theme.breakpoints.down('md')]: {
                            width: '100px',
                        },
                        width: '200px',
                    }}
                />
                
            </Grid>
            <Grid item xs={12} sm={6}>
                <BotaoLoginGovBr link={`${govBrConstants.urlProvider}/authorize?${qs}`} />
            </Grid>
        </Grid>
    )
}
