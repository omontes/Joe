SELECT F.Fecha,F.`idFactura` AS NumFactura, F.Nota AS Descripcion ,
SUM(PCF.`Cantidad`) AS TotalItem,F.TotalFacturado 
FROM factura AS F, productocantidadfact AS PCF, persona AS C
WHERE F.idCliente=C.`idPersona` AND PCF.`idFactura` = F.`idFactura` 
AND C.`Nombre` = ? AND F.Fecha BETWEEN ? AND ?
GROUP BY F.`idFactura`;