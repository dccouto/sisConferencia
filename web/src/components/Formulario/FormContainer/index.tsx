import { Grid, Paper, PaperProps } from '@mui/material'
import { FormEvent, FormEventHandler, ReactNode } from 'react'

interface FormContainerProps extends PaperProps {
    children: ReactNode
    onSubmitHandler?: FormEventHandler
}

export function FormContainer({ children, onSubmitHandler, sx, ...paperProps }: FormContainerProps) {
    return (
        <Paper
            sx={{
                backgroundColor: 'background.form',
                my: 2,
                p: 1,
                boxShadow: 'none',
                textAlign: 'center',
                ...sx,
            }}
            {...paperProps}
        >
            <Grid
                component='form'
                container
                spacing={1}
                onSubmit={(event: FormEvent<Element>) => {
                    if (onSubmitHandler) {
                        onSubmitHandler(event)
                    }
                }}
            >
                {children}
            </Grid>
        </Paper>
    )
}
