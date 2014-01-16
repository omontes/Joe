SELECT DISTINCT F.`Fecha`,F.`idFactura` AS Factura, C.`Nombre` AS Cliente,
V.`Nombre` AS Vendedor,F.`TotalFacturado`
FROM Factura AS F, Persona AS C, Persona AS V
WHERE F.`Concepto` = "Modificada" AND F.`Estado`="I" 
AND C.`idPersona` =F.`idCliente` AND V.`idPersona` = F.`idVendedor` ;