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

import { IFormato } from '../../../services/sisConferenciaApi/formato/types'

import { RHFText } from '../../../components/Formulario/reactHookForms/RHFText'
import { BotaoPadrao } from '../../../components/Formulario/BotaoPadrao'

import { useToast } from '../../../hooks/useToast'
import Mask from '../../../utils/mask'
import { useNavigate } from 'react-router-dom'
import { CustomTable } from '../../../components/Tabela/CustomTable'
import { RHFDate } from '../../../components/Formulario/reactHookForms/RHFDate'

interface ColumnConfig {
    key: string
    displayName: string
    width?: number
    visible?: boolean
}

interface Props {
    visible: boolean
    formatos: IFormato[]
    setFormatos: (formatos: IFormato[]) => void
    apiService:any
    columnConfig: ColumnConfig[]
}

const FormatoCrud = ({ visible, formatos, setFormatos,apiService,columnConfig }: Props) => {
    const navigate = useNavigate()
    const [isForm, setIsForm] = useState(false)
    const [editItem, setEditItem] = useState<IFormato | null>(null)

    const adicionarFormato = (item: IFormato) => {
        const index = formatos.findIndex((formato) => formato.id === item.id)
    
        if (index !== -1) {
            const updatedFormatos = [...formatos]
            updatedFormatos[index] = item
            setFormatos(updatedFormatos)
        } else {
            setFormatos([...formatos, item])
        }
    }

    const deletarFormato = async (item: IFormato) => {
        const list = formatos.filter((c) => c.id !== item.id)
        await apiService.excluir(item.id)
        setFormatos(list)
    }

    const verifyDuplicateDescricao = (txtDescricao: string) => {
        txtDescricao = Mask.numeros(txtDescricao)
        const find = formatos.find((formato) => String(formato.descricao) === txtDescricao)
        if (find) return false
        return true
    }

    const { toastSuccess, toastError } = useToast()

    const FormSchema = yup.object().shape({

        numero: yup.string().required('Número é obrigatório *'),
        dataFormato: yup.string().required('Data é obrigatório *'),
        descricao: yup
            .string()
            .required('Descrição é obrigatório *')
            .test('test-descricao', 'Tipo de Evento já cadastrado', (value: any) => {
                return verifyDuplicateDescricao(value)
            }),
    })

    const rhfmethods = useForm<IFormato>({ resolver: yupResolver(FormSchema) })

    const handleSalvar = async (values: IFormato) => {
        try {
            let dataSave = {
                id: values.id,
                descricao: values.descricao,
               
            }
            let formato: IFormato

            if (editItem) {
                formato = await apiService.atualizar(dataSave.id, dataSave)
            } else {
                formato = await apiService.criar(dataSave)
            }
            adicionarFormato(formato)
            toastSuccess('Tipo de Evento adicionado com sucesso.')
            setIsForm(false)
            setEditItem(null)
        } catch (error) {
            console.log(error)
            toastError('Erro ao adicionar tipo de Evento')
        }
    }

    const handleEditar = (item: IFormato) => {
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
                            data={formatos}
                            onEdit={handleEditar}
                            onDelete={deletarFormato}
                            columnConfig={columnConfig}
                        />
                        
                        <Dialog {...rhfmethods} open={isForm} onClose={() => setIsForm(false)}>
                            <DialogTitle>Cadastrar Formato</DialogTitle>
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
                                            Salvar Formato
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

export default FormatoCrud
