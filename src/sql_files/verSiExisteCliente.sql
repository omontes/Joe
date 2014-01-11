SELECT P.Nombre
FROM persona AS P,tipopersona AS V
WHERE P.Nombre=? AND P.idTipoPersona=V.idTipoPersona AND V.tipo='Cliente';
