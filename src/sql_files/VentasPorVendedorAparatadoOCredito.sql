SELECT F.Fecha,F.`idFactura` AS NumFactura, F.Nota AS Descripcion ,
SUM(PCF.`Cantidad`) AS TotalItem,FP.Saldo,F.TotalFacturado 
FROM factura AS F, productocantidadfact AS PCF, persona AS V, 
Facturaspendientes AS FP
WHERE F.`idVendedor`=V.`idPersona` AND PCF.`idFactura` = F.`idFactura` 
AND V.`Nombre` =?  AND F.Fecha BETWEEN ? AND ? AND F.Concepto=?
AND F.`idFactura`=FP.`idFactura`
GROUP BY F.`idFactura`;
