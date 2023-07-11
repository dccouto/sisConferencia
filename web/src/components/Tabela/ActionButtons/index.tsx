import { Grid, IconButton, Tooltip } from '@mui/material'
import { ReactNode, useState } from 'react'
import { IUserPermissions, UserHasPermission } from '../../UserHasPermission'
import CircularProgress from '@mui/material/CircularProgress'

export interface IconfigButton {
    icon: ((tableMeta: any) => ReactNode) | ReactNode
    color?: string
    action: (value: any, toggleLoading: (loading: boolean) => void, tableMeta: any) => void
    permission?: IUserPermissions
    disabled?: (tableMeta: any) => boolean
    tooltip?: ((tableMeta: any) => string) | string
}

interface IActionButtonsProps {
    config: IconfigButton[]
    columnValue?: string
    tableMeta?: any
}

export function ActionButtons({ config, columnValue, tableMeta }: IActionButtonsProps) {
    const [loading, setLoading] = useState(false)

    function toggleLoading(l: boolean) {
        setLoading(l)
    }

    return (
        <Grid container aria-label='Ações' justifyContent={'end'}>
            <Grid item display='flex' gap={2}>
                {config.map((config, index) => {
                    const disabled = config?.disabled !== undefined ? config?.disabled(tableMeta) : false

                    const tooltipMessage =
                        typeof config?.tooltip === 'function' ? config.tooltip(tableMeta) : config.tooltip

                    return (
                        <UserHasPermission key={index} componentPermission={config.permission}>
                            <Tooltip title={tooltipMessage || ' '}>
                                <span>
                                    <IconButton
                                        sx={{
                                            border: ' 2px solid',
                                            borderRadius: '10px',
                                            color: (theme) => config.color ?? theme.palette.secondary.main,
                                        }}
                                        onClick={(e) => {
                                            e.stopPropagation()
                                            config.action(columnValue || '', toggleLoading, tableMeta || [])
                                        }}
                                        disabled={disabled || loading}
                                    >
                                        {loading ? (
                                            <CircularProgress size={22} color='inherit' />
                                        ) : typeof config.icon === 'function' ? (
                                            config.icon(tableMeta)
                                        ) : (
                                            config.icon
                                        )}
                                    </IconButton>
                                </span>
                            </Tooltip>
                        </UserHasPermission>
                    )
                })}
            </Grid>
        </Grid>
    )
}
