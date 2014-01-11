SELECT P.Nombre
FROM persona AS P,tipopersona AS V
WHERE P.idTipoPersona=V.idTipoPersona AND V.tipo='Vendedor';
