import * as React from "react";
import { List, Datagrid, TextField, EditButton, DeleteButton, ListProps } from 'react-admin';

export const PostList = (props: ListProps) => (
    <List {...props}>
        <Datagrid>
            <TextField source={"id" as any} />
            <TextField source={"title" as any} />
            <TextField source={"body" as any} />
            <EditButton />
            <DeleteButton />
        </Datagrid>
    </List>
);
