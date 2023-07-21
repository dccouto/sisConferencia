import { useEffect, useState } from 'react'
import { FormProvider, useForm } from 'react-hook-form'
import { yupResolver } from '@hookform/resolvers/yup'
import * as yup from 'yup'
import { format } from 'date-fns'

import {
    Box,
    Dialog,
    DialogTitle,
    DialogContent,
    Grid,
    Typography,
} from '@mui/material'



import { RHFText } from '../../../components/Formulario/reactHookForms/RHFText'
import { BotaoPadrao } from '../../../components/Formulario/BotaoPadrao'

import { useToast } from '../../../hooks/useToast'
import Mask from '../../../utils/mask'
import { useNavigate } from 'react-router-dom'
import { CustomTable } from '../../../components/Tabela/CustomTable'
import { RHFDate } from '../../../components/Formulario/reactHookForms/RHFDate'
import { ITipoFormato } from '../../../services/sisConferenciaApi/eventos/types'

interface ColumnConfig {
    key: string
    displayName: string
    width?: number
    visible?: boolean
}

interface Props {
    visible: boolean
    tipoFormatos: ITipoFormato[]
    setTipoFormatos: (tipoFormatos: ITipoFormato[]) => void
    apiService:any
    columnConfig: ColumnConfig[]
}

const TipoFormatoCrud = ({ visible, tipoFormatos, setTipoFormatos,apiService,columnConfig }: Props) => {
    const navigate = useNavigate()
    const [isForm, setIsForm] = useState(false)
    const [editItem, setEditItem] = useState<ITipoFormato | null>(null)

    const adicionarTipoFormato = (item: ITipoFormato) => {
        const index = tipoFormatos.findIndex((tipoFormato) => tipoFormato.id === item.id)
    
        if (index !== -1) {
            const updatedTipoFormatos = [...tipoFormatos]
            updatedTipoFormatos[index] = item
            setTipoFormatos(updatedTipoFormatos)
        } else {
            setTipoFormatos([...tipoFormatos, item])
        }
    }

    const deletarTipoFormato = async (item: ITipoFormato) => {
        const list = tipoFormatos.filter((c) => c.id !== item.id)
        await apiService.excluir(item.id)
        setTipoFormatos(list)
    }

    const verifyDuplicateDescricao = (txtDescricao: string) => {
        txtDescricao = Mask.numeros(txtDescricao)
        const find = tipoFormatos.find((tipoFormato) => String(tipoFormato.descricao) === txtDescricao)
        if (find) return false
        return true
    }

    const { toastSuccess, toastError } = useToast()

    const FormSchema = yup.object().shape({

        numero: yup.string().required('Número é obrigatório *'),
        dataTipoFormato: yup.string().required('Data é obrigatório *'),
        descricao: yup
            .string()
            .required('Descrição é obrigatório *')
            .test('test-descricao', 'Tipo de Evento já cadastrado', (value: any) => {
                return verifyDuplicateDescricao(value)
            }),
    })

    const rhfmethods = useForm<ITipoFormato>({ resolver: yupResolver(FormSchema) })

    const handleSalvar = async (values: ITipoFormato) => {
        try {
            let dataSave = {
                id: values.id,
                descricao: values.descricao,
               
            }
            let tipoFormato: ITipoFormato

            if (editItem) {
                tipoFormato = await apiService.atualizar(dataSave.id, dataSave)
            } else {
                tipoFormato = await apiService.criar(dataSave)
            }
            adicionarTipoFormato(tipoFormato)
            toastSuccess('Tipo de Evento adicionado com sucesso.')
            setIsForm(false)
            setEditItem(null)
        } catch (error) {
            console.log(error)
            toastError('Erro ao adicionar tipo de Evento')
        }
    }

    const handleEditar = (item: ITipoFormato) => {
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
                            data={tipoFormatos}
                            onEdit={handleEditar}
                            onDelete={deletarTipoFormato}
                            columnConfig={columnConfig}
                        />
                        
                        <Dialog {...rhfmethods} open={isForm} onClose={() => setIsForm(false)}>
                            <DialogTitle>Cadastrar TipoFormato</DialogTitle>
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
                                            Salvar TipoFormato
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
                                ADICIONAR NOVO FORMATO DE EVENTO
                            </BotaoPadrao>
                            </Grid>
                        </Grid>
                    </>
                )}
            </FormProvider>
        </>
    )
}

export default TipoFormatoCrud
