SELECT F.Fecha,F.`idFactura` AS NumFactura, F.Nota AS Descripcion ,
SUM(PCF.`Cantidad`) AS TotalItem,(F.`TotalTarjeta`+F.`TotalContado`)AS TotalFacturado 
FROM factura AS F, productocantidadfact AS PCF, persona AS C
WHERE F.idCliente=C.`idPersona` AND PCF.`idFactura` = F.`idFactura` 
AND F.`Estado`="A" AND C.`Nombre` != "admin" AND SUBSTRING(F.Fecha,1,10) BETWEEN "2013/03/01" AND "2014/07/01"
AND F.`idVersionFactura` = PCF.`idVersionFacturasProducto`
GROUP BY F.`idFactura`;