import { Link as RouterDomLink, useNavigate } from 'react-router-dom'
import { Breadcrumbs as MuiBreadcrumbs, Divider, Grid, Link as MuiLink, Typography } from '@mui/material'
import HomeIcon from '@mui/icons-material/Home'
import NavigateNextIcon from '@mui/icons-material/NavigateNext'
import { memo } from 'react'
import { useDrawer } from '../../CidadaniaApp/Drawer/hooks/useDrawer'
import ArrowBackIcon from '@mui/icons-material/ArrowBack'

interface IPrevCrumbs {
    to?: string
    name: string
}

interface IBreadcrumbsProps {
    current: string
    prevCrumbs?: IPrevCrumbs[]
    homeTo?: string
    withDivider?: boolean
}

function BreadcrumbsComponent({ current, prevCrumbs = [], homeTo = '/home', withDivider = true }: IBreadcrumbsProps) {
    const { isDesktop } = useDrawer()

    const navigate = useNavigate()

    var lastCrumb = prevCrumbs[prevCrumbs.length - 1]

    const pathGoBack = lastCrumb?.to || '/'

    if (!isDesktop) {
        return (
            <Grid container alignItems={'center'} marginBottom={1}>
                <Grid item xs={1}>
                    <MuiLink
                        sx={{ cursor: 'pointer', display: 'flex', alignItems: 'center' }}
                        underline='hover'
                        color='secondary'
                        onClick={() => navigate(pathGoBack)}
                    >
                        <ArrowBackIcon sx={{ fontSize: 20 }} />
                    </MuiLink>
                </Grid>
                <Grid item xs={10}>
                    <Typography variant='body1'>{current}</Typography>
                </Grid>
            </Grid>
        )
    }

    return (
        <>
            {/*separator={<NavigateNextIcon fontSize="small" />}*/}
            <MuiBreadcrumbs separator={<NavigateNextIcon fontSize='small' sx={{ color: '#D4D4D4' }} />}>
                <MuiLink underline='hover' color='secondary' component={RouterDomLink} to={homeTo}>
                    <HomeIcon />
                </MuiLink>
                {prevCrumbs.map((crumb) => {
                    if (crumb.to) {
                        return (
                            <MuiLink
                                key={crumb.name}
                                underline='hover'
                                color='secondary'
                                component={RouterDomLink}
                                to={crumb.to}
                            >
                                {crumb.name}
                            </MuiLink>
                        )
                    } else {
                        return (
                            <Typography key={crumb.name} sx={{ fontWeight: 600 }}>
                                {crumb.name}
                            </Typography>
                        )
                    }
                })}
                <Typography sx={{ fontWeight: 600 }}>{current}</Typography>
            </MuiBreadcrumbs>

            {withDivider && <Divider sx={{ my: 1 }} />}
        </>
    )
}

export const Breadcrumbs = memo(BreadcrumbsComponent, (prevProps, nextProps) => {
    return prevProps.current === nextProps.current
})
