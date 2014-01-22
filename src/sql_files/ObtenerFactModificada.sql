SELECT  F.`Fecha`,F.`idFactura` AS Factura, C.`Nombre` AS Cliente,
V.`Nombre` AS Vendedor,F.`TotalFacturado`
FROM Factura AS F, Persona AS C, Persona AS V
WHERE F.`idFactura` = ? AND F.`Estado`="A" AND C.`idPersona` =F.`idCliente` 
AND V.`idPersona` = F.`idVendedor`;
