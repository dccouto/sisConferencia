import { useEffect, useMemo } from 'react'
import { RHFSelect } from '../reactHookForms/RHFSelect'
import { GridProps, MenuItem } from '@mui/material'
import { useFormContext } from 'react-hook-form'
import { useQuery } from 'react-query'
import { RHFAutocomplete } from '../reactHookForms/RHFAutocomplete'

// Types
import { IAutocompleteDefaultOption } from '../../../types'

// Services
import { apiGetMunicipio, apiGetUfListar } from '../../../services/utils'

interface IComboUfMunicipio {
    ufs: string[]
    gridProps?: GridProps
    getPopulacao?: (quantidade: number) => void
}

ComboUfMunicipio.defaultProps = {
    ufs: [],
}

export function ComboUfMunicipio({ ufs, gridProps, getPopulacao }: IComboUfMunicipio) {
    const { watch, setValue } = useFormContext()

    const selectUf = watch('uf')
    const selectMunicipio = watch('municipio')

    // Passar as ufs para filtrar
    const ufsQuery = useQuery(['ufs', ufs], () => apiGetUfListar(ufs), {
        staleTime: 1000 * 60 * 60 * 24, // 24h
    })

    const munQuery = useQuery(['municipios', selectUf], () => apiGetMunicipio(selectUf), {
        staleTime: 1000 * 60 * 60 * 24, // 24h
        enabled: !!selectUf,
    })

    useEffect(() => {
        setValue('municipio', '')

        if (getPopulacao) {
            // getPopulacao(0)
        }
    }, [getPopulacao, selectUf, setValue])

    const municipios: IAutocompleteDefaultOption[] = useMemo(() => {
        if (!munQuery.data || ufsQuery.isFetching) {
            return []
        }

        const lista = munQuery.data.map((m: any) => ({
            cod: m.id,
            desc: m.noMunicipio,
            populacao: m.qtdPopulacao,
        }))

        const findMun = lista.find((m: any) => String(m.cod) === String(selectMunicipio))

        if (findMun) {
            setValue('municipio', {
                cod: findMun.cod,
                desc: findMun.desc,
            })
        }

        return lista
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [ufsQuery, munQuery])

    useEffect(() => {
        if (munQuery.data) {
            const findMun = munQuery.data.find((m: any) => String(m.id) === String(selectMunicipio.cod))

            if (findMun && getPopulacao) {
                getPopulacao(findMun.qtdPopulacao)
            }
        }

        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [munQuery, selectMunicipio])

    return (
        <>
            <RHFSelect
                id='uf'
                name='uf'
                label='UF'
                isLoading={ufsQuery.isLoading || ufsQuery.isFetching}
                gridProps={gridProps}
                InputLabelProps={{ shrink: true }}
            >
                {ufsQuery.data &&
                    ufsQuery.data.map((uf: any, key: number) => {
                        return (
                            <MenuItem key={key} value={uf.id}>
                                {uf.sgUF}
                            </MenuItem>
                        )
                    })}
            </RHFSelect>

            <RHFAutocomplete
                name='municipio'
                label='Município'
                options={municipios}
                isLoading={munQuery.isLoading || munQuery.isFetching}
                disabled={!selectUf}
                gridProps={gridProps}
                customOnChange={(value) => {
                    if (getPopulacao) {
                        getPopulacao(value.populacao)
                    }
                }}
            />
        </>
    )
}
