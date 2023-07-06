import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import MenuItem from '@mui/material/MenuItem';
import '../../utils/reservation.css';

export default function SelectTextFields({ values, lable, def, pop, changeHandler }) {
  return (
    <Box
      component="form"
      sx={{
        '& .MuiTextField-root': { mt: 1, width: '10ch' }
      }}
      noValidate
      autoComplete="off">
      <div>
        <TextField
          id="outlined-select-currency"
          select
          label={lable}
          defaultValue={def}
          size="small"
          InputProps={pop}
          onChange={changeHandler}>
          {values.map((option) => (
            <MenuItem key={option.value} value={option.value}>
              {option.label}
            </MenuItem>
          ))}
        </TextField>
      </div>
    </Box>
  );
}
