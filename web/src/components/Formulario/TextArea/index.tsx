import { TextField, Grid, GridProps } from "@mui/material";
import { Control, Controller, FieldValues } from "react-hook-form";

interface RHFTextAreaProps {
  name: string;
  label: string;
  control: Control<FieldValues>;
  rules?: any;
  defaultValue?: string | number;
  rows?: number;
  gridProps?: GridProps;
  onChange?: (event: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => void; 
}

const RHFTextArea: React.FC<RHFTextAreaProps> = ({
  name,
  label,
  control,
  rules,
  defaultValue,
  rows,
  gridProps,
  onChange
}) => {
  return (
    <Grid item {...gridProps}>
      <Controller
        name={name}
        control={control}
        rules={rules}
        defaultValue={defaultValue}
        render={({ field }) => (
          <TextField
            {...field}
            label={label}
            multiline
            rows={rows}
            fullWidth
            variant="outlined"
            onChange={(e) => {
                if(onChange) {
                  onChange(e); // Aqui chamamos o onChange personalizado
                }
                field.onChange(e); // E mantemos o field.onChange para o funcionamento correto do react-hook-form
              }}
          />
        )}
      />
    </Grid>
  );
};

export default RHFTextArea;
