import * as React from 'react'
import { Controller, useFormContext } from 'react-hook-form'
import { Autocomplete, AutocompleteProps, FormControlProps, GridProps, TextField } from '@mui/material'
import { AutocompleteRenderInputParams } from '@mui/material/Autocomplete/Autocomplete'
import { FieldContainer } from '../../FieldContainer'

// Types
import { IAutocompleteDefaultOption } from '../../../../types'

/*
 * Integração do autocomplete (select com pesquisa) do mui com react-hook-forms
 * Documentação:
 * https://mui.com/pt/components/autocomplete/
 * */

type IAutoComplete = Omit<AutocompleteProps<any, any, any, any>, 'renderInput'>

interface IReactHookFormAutocompleteProps extends IAutoComplete {
    name: string
    label: string
    options: IAutocompleteDefaultOption[] | Array<any>
    isLoading?: boolean
    customOnChange?: (value: any) => void
    gridProps?: GridProps
    formControlProps?: FormControlProps
    renderInput?: (params: AutocompleteRenderInputParams) => React.ReactNode
}

export function RHFAutocomplete({
    name,
    label,
    options,
    isLoading,
    defaultValue,
    gridProps,
    formControlProps,
    renderInput,
    customOnChange,
    ...autoCompleteProps
}: IReactHookFormAutocompleteProps) {
    const {
        control,
        formState: { errors },
    } = useFormContext()

    return (
        <FieldContainer formControlProps={formControlProps} gridProps={gridProps}>
            <Controller
                name={name}
                control={control}
                render={({ field: { onChange, value, ref } }) => (
                    <Autocomplete
                        selectOnFocus
                        blurOnSelect
                        handleHomeEndKeys
                        filterSelectedOptions
                        ref={ref}
                        options={options}
                        loading={isLoading}
                        loadingText='Carregando...'
                        noOptionsText='Nenhuma opção encontrada'
                        clearText='Limpar'
                        openText='Abrir'
                        getOptionLabel={(option) => (option ? option.desc : '')}
                        isOptionEqualToValue={(option, value) => {
                            if (!option || !value) {
                                return false
                            }

                            return String(option.cod) === String(value.cod)
                        }}
                        renderInput={(params: any) => {
                            params.inputProps.value = value ? value.desc : ''

                            return (
                                <TextField
                                    {...params}
                                    label={label}
                                    error={!!errors[name]}
                                    helperText={errors[name]?.message}
                                    variant='filled'
                                />
                            )
                        }}
                        onChange={(_, value) => {
                            if (customOnChange) {
                                customOnChange(value || '')
                            }

                            onChange(value || '')
                        }}
                        {...autoCompleteProps}
                    />
                )}
            />
        </FieldContainer>
    )
}
