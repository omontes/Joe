SELECT F.Fecha,F.`idFactura` AS NumFactura, F.Nota AS Descripcion ,
SUM(PCF.`Cantidad`) AS TotalItem,(F.`TotalTarjeta`+F.`TotalContado`)AS TotalFacturado 
FROM factura AS F, productocantidadfact AS PCF, persona AS C
WHERE F.idCliente=C.`idPersona` AND PCF.`idFactura` = F.`idFactura` 
AND F.`Estado`="A" AND C.`Nombre` = ? AND SUBSTRING(F.Fecha,1,10) BETWEEN ? AND ?
AND F.`idVersionFactura` = PCF.`idVersionFacturasProducto` AND F.`Concepto` = "Cancelada"
GROUP BY F.`idFactura`

UNION 

SELECT DISTINCT F.`Fecha`,F.idFactura AS NumFact,F.`Nota` AS Descripcion,SUM(PCF.`Cantidad`) AS TotalItem,(SELECT FPP.`Saldo`+SUM(PFPP.`PagoContado`)+SUM(PFPP.`PagoTarjeta`) 
FROM Factura AS FF,FacturasPendientes AS FPP,PagosFactPendientes AS PFPP WHERE
FF.idFactura=F.idFactura AND FF.Estado='A'AND FF.idFactura=FP.idFactura AND FF.idVersionFactura=FPP.idVersionFactPendientes AND PFPP.idFacturaPendiente = FPP.idFactura AND PFPP.idFacturaVersionPagosPend = FPP.idVersionFactPendientes
) AS TotalFacturado
FROM Factura AS F,FacturasPendientes AS FP, Persona AS C, Persona AS V, PagosFactPendientes AS PFP,productocantidadfact AS PCF
WHERE  SUBSTRING(F.Fecha,1,10) BETWEEN ? AND ? AND F.`idCliente` = C.`idPersona` AND C.`Nombre` = ? AND (F.Concepto = "Apartado" OR F.Concepto = "Credito") AND F.Estado='A' AND F.idFactura=FP.idFactura AND F.idCliente=C.idPersona AND F.idVendedor=V.idPersona
AND F.idVersionFactura=FP.idVersionFactPendientes AND PFP.idFacturaPendiente = FP.idFactura AND PFP.idFacturaVersionPagosPend = FP.idVersionFactPendientes AND F.`idVersionFactura` = PCF.`idVersionFacturasProducto` AND PCF.`idFactura`=F.`idFactura`
GROUP BY F.idFactura;