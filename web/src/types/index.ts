export * from './emergencia.type'
export * from './user.type'

export interface IAutocompleteDefaultOption {
    cod: number
    desc: string
}

export interface IMenuItem {
    id: string
    menu: string
    rota?: string
    funcionalidades: number[]
    submenu?: IMenuItem[]
}
