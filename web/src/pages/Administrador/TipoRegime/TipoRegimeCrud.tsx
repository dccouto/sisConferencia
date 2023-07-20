import { useEffect, useState } from 'react'
import { FormProvider, useForm } from 'react-hook-form'
import { yupResolver } from '@hookform/resolvers/yup'
import * as yup from 'yup'

import {
    Box,
    Dialog,
    DialogTitle,
    DialogContent,
    Grid,
    Typography,
} from '@mui/material'

import { ITipoRegime } from '../../../services/sisConferenciaApi/tipoRegime/types'

import { RHFText } from '../../../components/Formulario/reactHookForms/RHFText'
import { BotaoPadrao } from '../../../components/Formulario/BotaoPadrao'

import { useToast } from '../../../hooks/useToast'
import Mask from '../../../utils/mask'
import { useNavigate } from 'react-router-dom'
import { CustomTable } from '../../../components/Tabela/CustomTable'

interface ColumnConfig {
    key: string
    displayName: string
    width?: number
    visible?: boolean
}

interface Props {
    visible: boolean
    tipoRegimes: ITipoRegime[]
    setTipoRegimes: (tipoRegimes: ITipoRegime[]) => void
    apiService:any
    columnConfig: ColumnConfig[]
}

const TipoRegimeCrud = ({ visible, tipoRegimes, setTipoRegimes,apiService,columnConfig }: Props) => {
    const navigate = useNavigate()
    const [isForm, setIsForm] = useState(false)
    const [editItem, setEditItem] = useState<ITipoRegime | null>(null)

    const adicionarTipoRegime = (item: ITipoRegime) => {
        const index = tipoRegimes.findIndex((tipoRegime) => tipoRegime.id === item.id)
    
        if (index !== -1) {
            const updatedTipoRegimes = [...tipoRegimes]
            updatedTipoRegimes[index] = item
            setTipoRegimes(updatedTipoRegimes)
        } else {
            setTipoRegimes([...tipoRegimes, item])
        }
    }

    const deletarTipoRegime = async (item: ITipoRegime) => {
        const list = tipoRegimes.filter((c) => c.id !== item.id)
        await apiService.excluir(item.id)
        setTipoRegimes(list)
    }

    const verifyDuplicateDescricao = (txtDescricao: string) => {
        txtDescricao = Mask.numeros(txtDescricao)
        const find = tipoRegimes.find((tipoRegime) => String(tipoRegime.descricao) === txtDescricao)
        if (find) return false
        return true
    }

    const { toastSuccess, toastError } = useToast()

    const FormSchema = yup.object().shape({
        descricao: yup
            .string()
            .required('Descrição é obrigatório *')
            .test('test-descricao', 'Tipo de Regime já cadastrado', (value: any) => {
                return verifyDuplicateDescricao(value)
            }),
    })

    const rhfmethods = useForm<ITipoRegime>({ resolver: yupResolver(FormSchema) })

    const handleSalvar = async (values: ITipoRegime) => {
        try {
            let dataSave = {
                id: values.id,
                descricao: values.descricao,
            }
            let tipoRegime: ITipoRegime

            if (editItem) {
                tipoRegime = await apiService.atualizar(dataSave.id, dataSave)
            } else {
                tipoRegime = await apiService.criar(dataSave)
            }
            adicionarTipoRegime(tipoRegime)
            toastSuccess('Tipo de Regime adicionado com sucesso.')
            setIsForm(false)
            setEditItem(null)
        } catch (error) {
            console.log(error)
            toastError('Erro ao adicionar tipo de Regime')
        }
    }

    const handleEditar = (item: ITipoRegime) => {
        setEditItem(item)
        setIsForm(true)
        rhfmethods.reset(item)
    }

    const initializeFormFields = () => {
        setTimeout(() => {
            rhfmethods.setValue('descricao', '');
            rhfmethods.setValue('id', 0);
        }, 0);
    };

    return (
        <>
            <FormProvider {...rhfmethods}>
                {visible && (
                    <>
                        <CustomTable
                            data={tipoRegimes}
                            onEdit={handleEditar}
                            onDelete={deletarTipoRegime}
                            columnConfig={columnConfig}
                        />
                        
                        <Dialog {...rhfmethods} open={isForm} onClose={() => setIsForm(false)}>
                            <DialogTitle>Cadastrar Tipo de Regime</DialogTitle>
                            <DialogContent>
                                <Grid container xs={12} spacing={3} mt={1}>
                                    <RHFText
                                        name={'descricao'}
                                        label={'Descrição'}
                                        gridProps={{ xs: 12 }}
                                        inputProps={{ maxLength: 100 }}
                                        InputLabelProps={{ shrink: true }}
                                        onChange={(e) => {
                                            const v = e.target.value
                                            rhfmethods.setValue('descricao', v)
                                        }}
                                    />
                                </Grid>

                                <Grid container justifyContent={'end'} mt={2}>
                                    <Grid>
                                        <BotaoPadrao
                                            variant='outlined'
                                            onClick={() => setIsForm(false)}
                                            sx={{ p: 2 }}
                                            style={{ height: 50 }}
                                        >
                                            Cancelar
                                        </BotaoPadrao>
                                    </Grid>
                                    <Grid ml={2}>
                                        <BotaoPadrao
                                            type='button'
                                            onClick={rhfmethods.handleSubmit(handleSalvar)}
                                            style={{ height: 50 }}
                                            sx={{ p: 2 }}
                                        >
                                            Salvar Tipo de Regime
                                        </BotaoPadrao>
                                    </Grid>
                                </Grid>
                            </DialogContent>
                        </Dialog>

                        <Grid container spacing={2} my={4} mr={4} justifyContent={'end'}>
                            <Grid>
                                <BotaoPadrao size={'large'} variant='outlined' onClick={() =>{ 
                                setIsForm(true);
                                initializeFormFields();
                                }}>
                                ADICIONAR NOVO TIPO DE REGIME
                            </BotaoPadrao>
                            </Grid>
                        </Grid>
                    </>
                )}
            </FormProvider>
        </>
    )
}

export default TipoRegimeCrud
