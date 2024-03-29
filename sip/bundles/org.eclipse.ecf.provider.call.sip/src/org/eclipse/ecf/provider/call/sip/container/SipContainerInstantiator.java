/***********************************************************************************
 * Copyright (c) 2009 Harshana Eranga Martin and others. All rights reserved. This 
 * program and the accompanying materials are made available under the terms of 
 * the Eclipse Public License v1.0 which accompanies this distribution, and is 
 * available at 
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Harshana Eranga Martin <harshana05@gmail.com> - initial API and implementation
************************************************************************************/
package org.eclipse.ecf.provider.call.sip.container;

import org.eclipse.ecf.core.ContainerCreateException;
import org.eclipse.ecf.core.ContainerTypeDescription;
import org.eclipse.ecf.core.IContainer;
import org.eclipse.ecf.core.identity.ID;
import org.eclipse.ecf.provider.call.sip.identity.SipLocalParticipant;
import org.eclipse.ecf.provider.call.sip.identity.SipUriID;
import org.eclipse.ecf.provider.call.sip.identity.SipUriNamespace;
import org.eclipse.ecf.provider.generic.GenericContainerInstantiator;


public class SipContainerInstantiator extends GenericContainerInstantiator{
	
/* (non-Javadoc)
 * @see org.eclipse.ecf.provider.generic.GenericContainerInstantiator#createInstance(org.eclipse.ecf.core.ContainerTypeDescription, java.lang.Object[])
 */
@Override
public IContainer createInstance(ContainerTypeDescription description,
		Object[] args) throws ContainerCreateException {
	
	SipLocalParticipant localParty=null;
	if(args!=null){
		 localParty = new SipLocalParticipant(
				(SipUriID) new SipUriNamespace()
						.createInstance(new Object[] { "<sip:"+((ID)args[0]).getName()+">" }),
				(String)args[1], (String)args[2],(String)args[3]);
	}else{
		 localParty = new SipLocalParticipant(
				(SipUriID) new SipUriNamespace()
						.createInstance(new Object[] { "<sip:"+"2233369447@sip2sip.infp"+">" }),
				"Harshana Martin", "abcd","proxy.sipthor.net");
	}
	return new SipContainer(localParty);
}
}
