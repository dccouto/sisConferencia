import { FormControlProps, GridProps, TextField } from '@mui/material'
import { Controller, useFormContext } from 'react-hook-form'
import { IFieldPropsNoVariant } from '../RHFSelect'
import { FieldContainer } from '../../FieldContainer'

interface ReactHookFormTextProps extends IFieldPropsNoVariant {
    name: string
    label: string
    isLoading?: boolean
    formControlProps?: FormControlProps
    gridProps?: GridProps
}

export function RHFText({
    name,
    label,
    isLoading,
    formControlProps,
    gridProps,
    ...textFieldProps
}: ReactHookFormTextProps) {
    const {
        formState: { errors },
        register,
        control,
    } = useFormContext()
    return (
        <FieldContainer formControlProps={formControlProps} gridProps={gridProps}>
            <Controller
                name={name}
                control={control}
                render={({ field: { value, onChange, onBlur } }) => (
                    <TextField
                        label={label}
                        error={!!errors[name]}
                        helperText={errors[name]?.message}
                        {...register(name)}
                        inputProps={{
                            ...textFieldProps.inputProps,
                            style: {
                                color: isLoading ? '#6c6c6c' : textFieldProps.inputProps?.style?.color,
                                ...textFieldProps.inputProps?.style,
                            },
                        }}
                        value={isLoading ? 'Carregando...' : value}
                        onChange={onChange}
                        onBlur={onBlur}
                        {...textFieldProps}
                    />
                )}
            />
        </FieldContainer>
    )
}
