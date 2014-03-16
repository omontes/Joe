SELECT F.Fecha,C.Nombre,V.Nombre,FP.`Saldo`+ SUM(PFP.`MontoDePago`),F.Nota,F.Descuento
FROM factura AS F,persona AS C, persona AS V,FacturasPendientes AS FP, PagosFactPendientes AS PFP
WHERE F.idFactura=? AND F.Estado='A' AND F.idFactura=FP.idFactura AND F.idVersionFactura=FP.idVersionFactPendientes AND
PFP.`idFacturaPendiente` = FP.`idFactura` AND PFP.`idFacturaVersionPagosPend` = FP.`idVersionFactPendientes` AND 
(F.Concepto='Apartado' OR F.Concepto='Credito')AND F.idCliente=C.idPersona AND V.idPersona=F.idVendedor;
