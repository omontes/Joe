SELECT FP.Saldo,FP.`Saldo`+ SUM(PFP.`MontoDePago`)
FROM Factura AS F,FacturasPendientes AS FP, PagosFactPendientes AS PFP
WHERE F.Estado ='A' AND F.idFactura=FP.idFactura AND F.idFactura=? AND F.Concepto='Credito' AND F.idVersionFactura=FP.idVersionFactPendientes AND
PFP.`idFacturaPendiente` = FP.`idFactura` AND PFP.`idFacturaVersionPagosPend` = FP.`idVersionFactPendientes`;

