import { ReactNode } from "react";
import { FormControl, FormControlProps, Grid, GridProps } from "@mui/material";

interface FieldContainerProps {
  children: ReactNode;
  formControlProps?: FormControlProps;
  gridProps?: GridProps;
}

export function FieldContainer({
  children,
  formControlProps,
  gridProps,
}: FieldContainerProps) {
  return (
    <Grid item xs={12} {...gridProps}>
      <FormControl fullWidth {...formControlProps}>
        {children}
      </FormControl>
    </Grid>
  );
}
