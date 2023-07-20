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


import { RHFText } from '../../../components/Formulario/reactHookForms/RHFText'
import { BotaoPadrao } from '../../../components/Formulario/BotaoPadrao'

import { useToast } from '../../../hooks/useToast'
import Mask from '../../../utils/mask'
import { useNavigate } from 'react-router-dom'
import { CustomTable } from '../../../components/Tabela/CustomTable'
import { IEvento } from '../../../services/sisConferenciaApi/eventos/types'
import { IListaEventos } from '../../../services/sisConferenciaApi/eventos/types'

interface ColumnConfig {
    key: string
    displayName: string
    width?: number
    visible?: boolean
}

interface Props {
    visible: boolean
    eventos: IListaEventos
    setEventos: (Eventos: IListaEventos) => void
    apiService:any
    columnConfig: ColumnConfig[]
}

const EventosCrud = ({ visible, eventos, setEventos,apiService,columnConfig }: Props) => {
    const navigate = useNavigate()
    const [isForm, setIsForm] = useState(false)
    const [editItem, setEditItem] = useState<IEvento | null>(null)

    const adicionarEventos = (item: IEvento) => {
        const index = eventos.findIndex((evento) => evento.id === item.id)
    
        if (index !== -1) {
            const updatedEventos = [...eventos]
            updatedEventos[index] = item
            setEventos(updatedEventos)
        } else {
            setEventos([...eventos, item])
        }
    }

    const deletarEventos = async (item: IEvento) => {
        const list = eventos.filter((c) => c.id !== item.id)
        await apiService.excluir(item.id)
        setEventos(list)
    }

    const verifyDuplicateDescricao = (txtDescricao: string) => {
        txtDescricao = Mask.numeros(txtDescricao)
        const find = eventos.find((evento) => String(evento.objetivo) === txtDescricao)
        if (find) return false
        return true
    }

    const { toastSuccess, toastError } = useToast()

    const FormSchema = yup.object().shape({
        objetivo: yup
            .string()
            .required('Objetivo é obrigatório *')
            .test('test-descricao', 'Tipo de Evento já cadastrado', (value: any) => {
                return verifyDuplicateDescricao(value)
            }),
    })

    const rhfmethods = useForm<IEvento>({ resolver: yupResolver(FormSchema) })

    const handleSalvar = async (values: IEvento) => {
        try {
            let dataSave = {
                id: values.id,
                objetivo: values.objetivo,
            }
            let evento: IEvento

            if (editItem) {
                evento = await apiService.atualizar(dataSave.id, dataSave)
            } else {
                evento = await apiService.criar(dataSave)
            }
            adicionarEventos(evento)
            toastSuccess('Evento adicionado com sucesso.')
            setIsForm(false)
            setEditItem(null)
        } catch (error) {
            console.log(error)
            toastError('Erro ao adicionar Evento')
        }
    }

    const handleEditar = (item: IEvento) => {
        setEditItem(item)
        setIsForm(true)
        rhfmethods.reset(item)
    }

    const initializeFormFields = () => {
        setTimeout(() => {
            rhfmethods.setValue('objetivo', '');
            rhfmethods.setValue('id', 0);
        }, 0);
    };

    return (
        <>
            <FormProvider {...rhfmethods}>
                {visible && (
                    <>
                        <CustomTable
                            data={eventos}
                            onEdit={handleEditar}
                            onDelete={deletarEventos}
                            columnConfig={columnConfig}
                        />
                        
                       

                        <Grid container spacing={2} my={4} mr={4} justifyContent={'end'}>
                            <Grid>
                                <BotaoPadrao size={'large'} variant='outlined' onClick={() =>{ 
                                    navigate('/administracao/eventos/criar')
                                }}>
                                ADICIONAR NOVO EVENTO
                            </BotaoPadrao>
                            </Grid>
                        </Grid>
                    </>
                )}
            </FormProvider>
        </>
    )
}

export default EventosCrud
