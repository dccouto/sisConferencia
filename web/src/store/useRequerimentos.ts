import { create } from 'zustand'
import { createJSONStorage, persist } from 'zustand/middleware'
import { IEventos} from '../services/eventos/types'

type State = {
    evento: IEventos | undefined
    setEvento(requerimentoGeral: IEventos | undefined): void


    reset(): void
}

export const useRequerimentos = create(
    persist<State>(
        (set, get) => ({
         
            evento: undefined,
            setEvento(evento: IEventos) {
                set({ evento })
            },

    

            reset() {
                set({
                    evento: undefined,
                })
            },
        }),
        {
            name: 'useEvento', // name of the item in the storage (must be unique)
            storage: createJSONStorage(() => sessionStorage), // (optional) by default, 'localStorage' is used
        }
    )
)
