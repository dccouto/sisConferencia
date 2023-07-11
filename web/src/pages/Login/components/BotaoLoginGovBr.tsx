import { SxProps, Typography } from "@mui/material";
import { BotaoPadrao } from "../../../components/Formulario/BotaoPadrao";

interface IBotaoLoginGovBrProps {
  link: string;
}

const anchorSx: SxProps = {
  borderRadius: "100em",
  height: "40px",
  padding: "0 24px",
  textTransform: "none",
};

export function BotaoLoginGovBr({ link }: IBotaoLoginGovBrProps) {
  return (
    <BotaoPadrao sx={anchorSx} href={link}>
      Entrar com&nbsp;<Typography sx={{ fontWeight: 900 }}>gov.br</Typography>
    </BotaoPadrao>
  );
}
