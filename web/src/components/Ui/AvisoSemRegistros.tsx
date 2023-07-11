import { Paper, Typography } from "@mui/material";

interface AvisoSemRegistrosProps {
  texto?: string;
}

export function AvisoSemRegistros({ texto }: AvisoSemRegistrosProps) {
  return (
    <Paper
      sx={{
        bgcolor: "#FFFDFD",
        border: "1px solid #D4D4D4",
        borderRadius: "3px",
        boxShadow: "none",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        width: "100%",
        minHeight: "300px",
      }}
    >
      <Typography>{texto || "Não foram encontrados registros"}</Typography>
    </Paper>
  );
}
