SELECT  Dev.`Fecha`,Dev.`idDevolucion` AS DevFact,C.`Nombre` AS Cliente,V.`Nombre` 
AS Vendedor,Dev.`TotalFacturado`
FROM devolucion AS Dev, persona AS V, persona AS C
WHERE Dev.`idClienteDev` = C.`idPersona` AND Dev.`idVendedorDev` = V.`idPersona` 
AND Dev.`Estado` = "A" AND Dev.`idDevolucion` = 
ANY(SELECT DISTINCT Dev.`idDevolucion`
FROM devolucion AS Dev
WHERE Dev.`Concepto` = "Modificada" AND Dev.`Estado`="I");
