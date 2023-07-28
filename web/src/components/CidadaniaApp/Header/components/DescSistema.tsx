import { useDrawer } from '../../Drawer/hooks/useDrawer'






type DescSistemaProps = {
    fontSize: number,
    // Aqui você pode definir outras propriedades se precisar
};

export function DescSistema({ fontSize }: DescSistemaProps) {
    const { isDesktop } = useDrawer()

    const imageSize = isDesktop ? 50 : 40

    return (
        <a href='/'>
            <div style={{ display: 'flex', flexDirection: 'row', alignItems: 'center' }}>
                <div
                    style={{
                        width: 200,
                        height: 50,
                        marginLeft: 10,
                        display: 'flex',
                        alignItems: 'flex-end',
                    }}
                >
                    <div
                        style={{
                            fontSize: isDesktop ? fontSize : fontSize - 6,
                            color: '#15D2B6',
                            fontWeight: 'bold',
                            marginRight: '2px', // Ajuste este valor para mudar o espaço entre "SIS" e "Conferência"
                        }}
                    >
                    SIS
                    </div>
                    <div
                        style={{
                            fontSize: isDesktop ? fontSize : fontSize - 6,
                            color: '#1351B4',
                            fontWeight: 'bold',
                        }}
                    >
                    Conferência
                    </div>
                </div>
            </div>

        </a>
    )
}
