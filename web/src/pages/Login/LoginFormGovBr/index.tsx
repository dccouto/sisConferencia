import {  Grid } from '@mui/material'
import { govBrConstants } from '../../../utils/constants'
import { BotaoLoginGovBr } from '../components/BotaoLoginGovBr'

export default function LoginForm() {
    
    const qs = [
        'response_type=code',
        `client_id=${govBrConstants.clientId}`,
        'scope=openid',
        `redirect_uri=${govBrConstants.redirectUri}`,
    ].join('&')

    return (
        <Grid container spacing={3} justifyContent='center' alignItems='center'>
            <Grid item xs={12} sm={6}>
                <BotaoLoginGovBr link={`${govBrConstants.urlProvider}`} />
            </Grid>
        </Grid>
    )
}
