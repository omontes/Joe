SELECT date_format(F.`Fecha`,'%d/%m/%Y %r') AS Fecha,F.`idFactura` AS NumFact,C.`Nombre` AS Cliente,V.`Nombre` 
AS Vendedor,(F.`TotalTarjeta`+F.`TotalContado`) AS TotalFacturado
FROM factura AS F, persona AS V, persona AS C
WHERE F.`idCliente` = C.`idPersona` AND F.`idVendedor` = V.`idPersona` 
AND F.`Estado` ="A" AND F.`idFactura` = 
ANY(SELECT DISTINCT F.`idFactura`
FROM Factura AS F
WHERE F.`Concepto` = "Modificada" AND F.`Estado`="I");