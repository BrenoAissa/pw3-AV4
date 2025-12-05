ALTER TABLE consertos ADD COLUMN ativo BOOLEAN;

UPDATE consertos SET ativo = TRUE;