import { FilledTextFieldProps, FormControlProps, GridProps, MenuItem, TextField, Typography } from '@mui/material'
import { ReactNode } from 'react'
import { Controller, useFormContext } from 'react-hook-form'
import { FieldContainer } from '../../FieldContainer'

/*
* Exemplo de uso:
  <RHFSelect name={"orgao"} label={"Órgão"}>
    <MenuItem value="MC">Ministério da Cidadania</MenuItem>
    <MenuItem value="CGU">Controladoria Geral da União</MenuItem>
    <MenuItem value="TCu">Tribunal de Contas da União</MenuItem>
  </RHFSelect>
* */

export type IFieldPropsNoVariant = Omit<FilledTextFieldProps, 'variant'>

interface IReactHookFormSelectProps extends IFieldPropsNoVariant {
    name: string
    label: string
    children: ReactNode
    isLoading?: boolean
    formControlProps?: FormControlProps
    gridProps?: GridProps
}

export function RHFSelect({
    name,
    label,
    children,
    formControlProps,
    isLoading,
    gridProps,
    ...textFieldProps
}: IReactHookFormSelectProps) {
    const {
        formState: { errors },
        control,
    } = useFormContext()

    return (
        <FieldContainer formControlProps={formControlProps} gridProps={gridProps}>
            <Controller
                name={name}
                control={control}
                defaultValue={''}
                render={({ field }) => (
                    <TextField
                        select
                        variant='filled'
                        label={label}
                        error={!!errors[name]}
                        helperText={errors[name]?.message}
                        {...textFieldProps}
                        {...field}
                        value={isLoading ? '0' : field.value}
                    >
                        {isLoading ? (
                            <MenuItem value='0' selected disabled>
                                <Typography color={'#6c6c6c'}>Carregando...</Typography>
                            </MenuItem>
                        ) : null}
                        {children}
                    </TextField>
                )}
            />
        </FieldContainer>
    )
}
