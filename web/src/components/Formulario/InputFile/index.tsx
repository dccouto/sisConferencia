import { FormControl, InputLabel, TextField, Grid, GridProps } from "@mui/material";
import { Control, Controller, FieldValues } from "react-hook-form";

interface RHFInputFileProps {
  name: string;
  label: string;
  control: Control<FieldValues>;
  gridProps?: GridProps;
  onFileChange: (e: React.ChangeEvent<HTMLInputElement>) => void ;
}

const RHFInputFile: React.FC<RHFInputFileProps> = ({
  name,
  label,
  control,
  gridProps,
  onFileChange,
}) => {
  return (
    <Grid item {...gridProps}>
      <FormControl fullWidth variant="outlined">
        <InputLabel shrink>{label}</InputLabel>
        <Controller
          name={name}
          control={control}
          render={({ field }) => (
            <TextField
              {...field}
              type="file"
              fullWidth
              variant="outlined"
              InputLabelProps={{ shrink: true }}
              onChange={(e) => {
                //field.onChange((e.target as HTMLInputElement).files);
                onFileChange(e as React.ChangeEvent<HTMLInputElement>);  // especificando o tipo do evento aqui
              }}
            />
          )}
        />
      </FormControl>
    </Grid>
  );
};

export default RHFInputFile;
